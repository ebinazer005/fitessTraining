import Navbar from "./Navbar";
import  Assistent  from "./assistentAi";
import "./home.css"

const Home = () => {
    return ( <>
    <Navbar />
    <div className="home">
       <Assistent /> 
    </div>  
 </> );
}
 
export default Home;