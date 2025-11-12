import { useState } from "react";
import { useSelector ,useDispatch } from "react-redux";
import { Assistent } from "../store/aiAssistent";
import './Ai_assistent.css'


const Aiassistent = () => {

    const dispatch =useDispatch();
    const { loading,error,userData} =useSelector((state)=>state.StoreAssistent);

    const [query,setQuery] =useState("")
    const [responseDetuctor,setResponseDetuctor] = useState(false);

    const sendRequset=()=>{
        if(query !== ""){
            dispatch(Assistent({query}),console.log("click"))
            setResponseDetuctor(true)
        }
        
    }
    return ( <>
        <div className="AI_Assistent">
            <div className="input-area">
                <textarea name="textarea" value={query} onChange={(event)=>setQuery(event.target.value)}  placeholder="I am AI Fitness assistent" ></textarea>
                <button onClick={sendRequset}>go</button>
            </div>
           {responseDetuctor ? (loading ? <p className="response">Loading...</p> : <p className="response">{userData?.response}</p>)  : (" ")} 
        </div>
               
        
           

    </> );
}
 
export default Aiassistent;