import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";


const endpoint="http://localhost:8000/assistent";

const initialState={
        loading:false,
        error :null,
        userData:null
}

export const Assistent = createAsyncThunk(
    "api/assistent",
    async({query},{rejectWithValue}) =>{
        try{
        const response =await axios.post(endpoint,{query});
        return response.data;
    }catch(error){
         return rejectWithValue(error.response?.data || "login Failed");
    }})
    

    const assistentSlice = createSlice({
        name:"sliceAssistent",
        initialState,
        reducers:{},
        extraReducers:(builder)=>{
            builder.addCase(Assistent.pending,(state)=>{
                state.loading=true,
                state.error=null
            })
            builder.addCase(Assistent.fulfilled,(state,action)=>{
                state.loading=false,
                state.userData  = action.payload
                state.error=null
            })
             builder.addCase(Assistent.rejected,(state,action)=>{
                state.loading = false,
                state.error = action.payload;
            })
        }
    })

    export default assistentSlice.reducer;