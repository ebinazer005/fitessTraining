import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import Signin from "../components/Signin";

const Loginurl = "http://localhost:8080/UserLogin";


const initialvalue ={
        loading :false,
        error :null,
        userdata : null,
       

};

//create createAsyncThunk  and send the email,password parameter to back-end {rejectWithValue} if exception throw it trigger
export const login = createAsyncThunk('user/login/',async({email,password},{rejectWithValue})=>{

    try{
        const response =await axios.post(Loginurl,{email,password});

        //get JWT token
         const token =response.data.token;

         //string to localstorege if jwt token match it allow to login 
        localStorage.setItem("token",token);

        return {token,email};
    }
    catch (error){
       return rejectWithValue(error.response?.data || "login Failed");
    }    
});

const loginSlice =createSlice({
    name : 'login',
    initialState :initialvalue,
    reducers :{

    },
    extraReducers:(builder)=>{
        builder.addCase(login.pending,(state)=>{
            state.loading = true,
            state.error = null;
        })
        builder.addCase(login.fulfilled,(state,action)=>{
            state.loading = false,
            state.userdata = 'success';
            state.email = action.payload.email;

        })
        builder.addCase(login.rejected,(state,action)=>{
             state.loading = false,
            state.error = action.payload;
        })
    } 
    

    
})

export default loginSlice.reducer;