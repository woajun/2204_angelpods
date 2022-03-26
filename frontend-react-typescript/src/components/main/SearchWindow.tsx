import React from 'react';
import Stack from '@mui/material/Stack';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import '../../css/test.css';
const SearchWindow = () => {
  return (
    // <Stack justifyContent="flex-start">
    <Paper elevation={5} className="searchWindow">
      <Typography variant="h6" component="h2" >
        [발견했어요] 검색
      </Typography>
      {/* <Stack direction="row" justifyContent="flex-start">
        <FormControl>
          <FormLabel id="demo-radio-buttons-group-label">Gender</FormLabel>
          <RadioGroup row defaultValue="f">
            <FormControlLabel value="f" control={<Radio sx={{ '& .MuiSvgIcon-root': { fontSize: 35, } }} />} label="발견했어요" />
            <FormControlLabel value="l" control={<Radio sx={{ '& .MuiSvgIcon-root': { fontSize: 35, } }} />} label="찾아주세요" />
          </RadioGroup>
        </FormControl>
      </Stack> */}
      <Stack direction="column" justifyContent="center" spacing={1}>
        <TextField label="Name" size="small" />
        <TextField label="Name" size="small" />
        <TextField label="Name" size="small" />
        <TextField label="Name" size="small" />
      </Stack>
    </Paper >
    // </Stack>
  );
};

export default SearchWindow;