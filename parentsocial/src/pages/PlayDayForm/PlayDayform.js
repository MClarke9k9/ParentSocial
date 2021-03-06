import { useState, useEffect} from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import "./playday.css"
import { SyntheticEvent } from "synthetic-event";
// import axios from 'axios';
import { createPlayDate } from '../../utils/API';
import { useHistory } from 'react-router';




const PlayDayForm = (props) => {
  
  const history = useHistory();

  const [title, setTitle] = useState('');
  const [event_time, setEvent_time] = useState('');
  const [description, setDescription] = useState('');

  const submit = () => {
    createPlayDate(title, description, event_time);
    // history.push("/playdate");
  };


  return (
      <div className="container">
    <Form>
      <FormGroup>
        <Label for="exampleTitle">Title</Label>
        <Input type="text" name="title" id="" placeholder="Enter a title"
        onChange={(e) => {setTitle(e.target.value)}} />
      </FormGroup>

      <FormGroup>
        <Label for="exampleText">Description</Label>
        <Input type="textarea" name="text" id="exampleText" placeholder="What are offering today 😊?"
         onChange={(e) => {setDescription(e.target.value)}}
        />

      </FormGroup>
      

    

 

         <Button href="/playdate" className="btn" onClick={submit}>Submit</Button>
    </Form>
    </div>
  );
}

export default PlayDayForm;
