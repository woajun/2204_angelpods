import React, { useState, useEffect, useRef } from 'react';
import axios from 'axios'
import styled from 'styled-components';
import { CSSTransition } from 'react-transition-group';

import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Paper from '@mui/material/Paper';


import SearchWindow from '../components/main/SearchWindow';
import EachPost from '../components/main/EachPost';
import ModalFind from '../components/main/ModalFind';
import '../css/test.css';
import fakeList from '../assets/fakeList';

// interface ListInterface {
//   board_id: number;
//   user_id: string;
//   m_category: string;
//   s_category: string;
//   lat: string;
//   lng: string;
//   title: string;
//   i_name: string;
//   get_time: string;
//   get_loc: string;
//   // image:
//   dt_created: string;
// }

const MainMap = () => {
  const container = useRef(null);
  const infoDiv = useRef(null);
  const [layout, setLayout] = useState(0);
  const [searchString, setSearchString] = useState('');
  const [latLng, setLatLng] = useState('');
  const [getLoc, setGetLoc] = useState('');
  const [list, setList] = useState<any>([]);

  // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
  function displayCenterInfo(result: any, status: any) {
    if (status === window.kakao.maps.services.Status.OK) {
      // var infoDiv = document.getElementById('centerAddr');

      for (var i = 0; i < result.length; i++) {
        // 행정동의 region_type 값은 'H' 이므로
        if (result[i].region_type === 'H') {
          // infoDiv.innerHTML = result[i].address_name;
          break;
        }
      }
    }
  }

  function makeMarkerWindow(item: any) {
    return `
    <div class="markerWindow">
      <h5 class="i_name">${item.iName}</h5>
      <h4>${item.title}</h4>
      <div>${item.getTime.replace('T', ' ').substr(0, 16)}</div>
    </div>`
  }

  useEffect(() => {
    const getList = async () => { //TODO: async-await 생각해보기
      await axios.get('http://localhost:5000/api/find')
        .then(res => {
          setList(res.data)
          console.log(res.data)
        })
        .catch(err => {
          console.error(err)
        })
    }
    getList();
    // setList(fakeList)
  }, [])

  useEffect(() => {

    // 카카오맵 클릭해서 현재 위도경도 얻기
    window.kakao.maps.load(() => {
      const markers = [];
      const options = {
        center: new window.kakao.maps.LatLng(37.5608795149701, 127.04006910627318),
        level: 1
      };
      const map = new window.kakao.maps.Map(container.current, options);
      // console.log("list", list)
      if (layout === 0) {
        for (var i = 0; i < list.length; i++) {
          list[i].latlng = new window.kakao.maps.LatLng(Number(list[i].lng), Number(list[i].lat))
          list[i].content = makeMarkerWindow(list[i])
          // 마커를 생성합니다
          const marker = new window.kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: list[i].latlng, // 마커를 표시할 위치
            title: list[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          });

          // 마커에 표시할 인포윈도우를 생성합니다 
          var infowindow = new window.kakao.maps.InfoWindow({
            content: list[i].content // 인포윈도우에 표시할 내용
          });
          // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
          // 이벤트 리스너로는 클로저를 만들어 등록합니다 
          // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
          window.kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
          window.kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

          markers.push(marker);
          markers[i].setMap(map);
        }
      }

      // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
      // searchAddrFromCoords(map.getCenter(), displayCenterInfo);
      if (layout === 1) {
        // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
        for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(null)
        }
      } else if (layout === 2) {
        // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
        for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(null)
        }

        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new window.kakao.maps.services.Geocoder();

        var marker = new window.kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
          infowindow = new window.kakao.maps.InfoWindow({ zindex: 1 }); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
        // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
        window.kakao.maps.event.addListener(map, 'click', function (mouseEvent: any) {
          searchDetailAddrFromCoords(mouseEvent.latLng, function (result: any, status: any) {
            if (status === window.kakao.maps.services.Status.OK) {

              var detailAddr =
                !!result[0].road_address
                  ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>'
                  : '';
              detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';

              var content =
                '<div class="bAddr">' +
                '<span class="title">법정동 주소정보</span>' +
                detailAddr +
                '</div>';

              // 마커를 클릭한 위치에 표시합니다 
              marker.setPosition(mouseEvent.latLng);
              marker.setMap(map);

              // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
              infowindow.setContent(content);
              infowindow.open(map, marker);

              setLatLng(mouseEvent.latLng);
              setGetLoc(result[0].address.address_name);
            }
          });
        });
        // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
        window.kakao.maps.event.addListener(map, 'idle', function () {
          searchAddrFromCoords(map.getCenter(), displayCenterInfo);
        });

      }

      function searchAddrFromCoords(coords: any, callback: any) { // 여기 있어야됨 
        // 좌표로 행정동 주소 정보를 요청합니다
        geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
      }

      function searchDetailAddrFromCoords(coords: any, callback: any) { // 여기 있어야됨 
        // 좌표로 법정동 상세 주소 정보를 요청합니다
        geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
      }
      // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
      function makeOverListener(map: any, marker: any, infowindow: any) {
        return function () {
          infowindow.open(map, marker);
        };
      }
      // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
      function makeOutListener(infowindow: any) {
        return function () {
          infowindow.close();
        };
      }
    });
  }, [layout, list])


  return (
    <>
      <div ref={container} id="map" style={{ width: "100vw", height: "calc(100vh - 70px)" }}>
        {
          (() => {
            if (layout === 0) {
              return (
                <Stack direction="column" justifyContent="space-between" className="overMap">
                  {/* <Stack direction="row-reverse" justifyContent="flex-end" alignItems="baseline" flexWrap="wrap" spacing={1}> */}
                  <Stack direction="row" spacing={1} sx={{ marginLeft: 'auto' }}>
                    <Button onClick={() => setLayout(2)} variant="contained" className="btn-write" >발견했어요</Button>
                    {/* <Button onClick={() => setLayout(2)} variant="contained" className="btn-write" >찾아주세요</Button> */}
                  </Stack>
                  {/* <SearchWindow /> */}
                  {/* </Stack> */}
                  <Stack className="posts" direction="row" justifyContent="flex-start" alignItems="flex-end" spacing={2}>
                    {
                      list.map((post: any, idx: any) => {
                        return <EachPost key={idx} post={post} />
                      })
                    }
                  </Stack>
                </Stack>
              )
            } else if (layout === 1) {
              return (
                <ModalFind
                  layout={layout}
                  setLayout={setLayout}
                  latLng={latLng}
                  getLoc={getLoc}
                  handleClose={() => { setLayout(0) }} />
              )
            } else if (layout === 2) {
              return (
                <Stack direction="column" className="overMap">
                  <Stack direction="row" spacing={1}>
                    <Paper component="form" sx={{ display: 'flex', justifyContent: 'center', alignSelf: 'flex-start', flexGrow: '2', padding: '0' }}>
                      <div className="hAddr">
                        <span ref={infoDiv}></span>
                      </div>
                      <div>지도에서 습득 장소를 선택해주세요</div>
                    </Paper>
                  </Stack>
                  <Stack direction="row" justifyContent="flex-end" spacing={1} sx={{ marginTop: 'auto' }}>
                    <Button onClick={() => { setLayout(0) }} variant="contained" size="large">돌아가기</Button>
                    <Button onClick={() => { setLayout(1) }} variant="contained" size="large">확인</Button>
                  </Stack>
                </Stack>
              )
            }
          })()
        }
      </div>
    </>
  );
};

export default MainMap;