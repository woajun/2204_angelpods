import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { textSpanContainsPosition } from 'typescript';
import { EventEmitter } from 'stream';

function App() {
  return (
    <div className="App">
      <button className="btn btn-primary" onClick={() => {
        axios.post('localhost:8080/api/find')
          .then((res) => {
            console.log(res)
          })
          .catch((err) => {
            console.error(err)
          })
      }}>API통신</button>
    </div>
  );
}


export default App;
