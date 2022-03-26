import React from 'react';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import Chip from '@mui/material/Chip';
import Divider from '@mui/material/Divider';


import '../../css/test.css';
const EachPost = (props: any) => {

  return (
    <Paper elevation={5} className="eachPost">
      <Stack direction="column" justifyContent="space-between" sx={{ height: '100%' }}>

        <Stack direction="row" spacing={0.5}>
          <img src="#" style={{ width: '55px', height: '55px' }} />
          <div style={{ display: 'flex', flexDirection: 'column', justifyContent: "space-between" }}>
            <Stack direction="row" justifyContent="flex-start" spacing={0.5}>
              <img src="#" style={{ width: '40px', height: '40px' }} />
              <img src="#" style={{ width: '40px', height: '40px' }} />
              <img src="#" style={{ width: '40px', height: '40px' }} />
              <img src="#" style={{ width: '40px', height: '40px' }} />
            </Stack>
            <Stack direction="row" justifyContent="space-between">
              <h5 style={{ alignSelf: 'end' }} >{props.post.iName}</h5>
              <h5>{props.post.getTime.replace('T', ' ').substr(0, 16)}</h5>
            </Stack>
          </div>
        </Stack>

        <Stack direction="column" >
          <div style={{ alignSelf: 'start' }}>
            <h4 className="title">
              {props.post.title}
            </h4>
          </div>
        </Stack>

        <Stack direction="row" justifyContent="space-between">
          <h5>honggildong@naver.com</h5>
          <Divider orientation="vertical" flexItem />
          <Chip style={{ alignSelf: 'end' }} label="댓글(n)" size="small" />
        </Stack>

      </Stack>
    </Paper>
  );
};

export default EachPost;