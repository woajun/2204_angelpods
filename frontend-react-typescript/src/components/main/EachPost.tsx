import React from 'react';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import Chip from '@mui/material/Chip';
import Divider from '@mui/material/Divider';


import '../../css/test.css';
const EachPost = (props: any) => {

  return (
    <Paper elevation={5} className="eachPost">
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
            <h5 style={{ alignSelf: 'end' }} >{props.post.i_name}</h5>
            <h5>n일전</h5>
          </Stack>
        </div>
      </Stack>
      <Stack direction="column" >
        <div style={{ alignSelf: 'start' }}>
          <h4 className="title" >{props.post.title} {props.post.title} {props.post.title}</h4>
        </div>
        <Stack direction="row" justifyContent="space-between">
          <h5>{props.post.user_id}</h5>
          <Divider orientation="vertical" flexItem />
          <Chip style={{ alignSelf: 'end' }} label="댓글(n)" size="small" />
        </Stack>
      </Stack>

    </Paper>
  );
};

export default EachPost;