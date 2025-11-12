
import { useDispatch, useSelector } from "react-redux";
import { fitnessThunk } from "../store/fitnessapi"
import { useEffect } from "react";
import "./dashboard.css"
import Navbar from "./Navbar";


const Dashboard = () => {

const {isloading ,error,userData} =useSelector((state)=>state.StoreFittness)
const dispatch = useDispatch()

 useEffect(() => {
    dispatch(fitnessThunk());
  }, [dispatch]);
    console.log(userData)



    return ( <>
    <Navbar />

    <div className="dashboard-container">
      
       {isloading ?<p>Loading...</p>:userData?.map((data,index)=>(<div key={index} className="content">
          <img src={`data:image/jpeg;base64,${data.imageBase64}`}/>
          <h1>{data.name}</h1>
          <h2>{data.muscle}</h2>
          <h3>{data.equipment}</h3>
          <p>{data.instruction}</p>
       </div>))}
    </div>
    
    </> );
}
 
export default Dashboard;