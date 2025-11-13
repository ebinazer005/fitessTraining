import { useState } from "react";
import { useSelector ,useDispatch } from "react-redux";
import { Assistent } from "../store/aiAssistent";
import './Ai_assistent.css'
import React from "react";



const Aiassistent = () => {

    const [responseVisiblity,setResponseVisiblity] = useState(false);

    const dispatch =useDispatch();
    const { loading,error,userData} =useSelector((state)=>state.StoreAssistent);

    const [query,setQuery] =useState("")
    const [responseDetuctor,setResponseDetuctor] = useState(true);

    const sendRequset=()=>{
        if(query !== ""){
            dispatch(Assistent({query}),console.log("click"))
            setResponseDetuctor(true)
            setResponseVisiblity(true)
        }
        
    }
    return ( <>
        <div className="AI_Assistent">
           {responseVisiblity && (<div className ="response-card">
            <button onClick={()=>setResponseVisiblity(false)}>close</button>
              {responseDetuctor ? (loading ? <p className="response">Loading...</p> :(<div className="response"> <ul>{userData?.response ?.split(/[0-9]+\.\s+/).filter(line => line.trim() !== '').map((line,index) =>(<li key={index}>{line.trim()}</li>))}</ul></div>))   : (" ")} 
            </div>) }
          
            
           
            <div className="input-area">
                <textarea name="textarea" value={query} onChange={(event)=>setQuery(event.target.value)}  placeholder="I am AI Fitness assistent" ></textarea>
                <button onClick={sendRequset}>go</button>
            </div>
        </div>
               
        
           

    </> );
}
 
export default Aiassistent;