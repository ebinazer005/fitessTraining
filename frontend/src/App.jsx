import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from "./components/Login"
import Signin from "./components/Signin"
import Home from './components/home'
import Dashboard from './components/dashborad'

import { createBrowserRouter ,RouterProvider } from 'react-router-dom'


function App() {

  const router =createBrowserRouter([
    {path : "/",element:<Home />},
    { path: "/login", element: <Login /> },
    { path: "/sigin", element: <Signin /> },
    {path : "/Dashboard" , element : <Dashboard />}
  
 
   ])
  return (
    <>
     <RouterProvider router={router}/> 

    {/* <Signin /> */}
    
    </>
  )
}

export default App
