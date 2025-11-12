import { createSlice ,createAsyncThunk } from "@reduxjs/toolkit";
import  axios  from "axios";

const initialValue = { loading:false,
                      error:null,
                      userData:null };

export const signinpage = createAsyncThunk(
  'user/signinpage',async({email,name,password,role},{ rejectWithValue })=>{
    try{
      const response = await axios.get('http://localhost:8080/sign',{
        params:{email,name,password,role},

      });
         // response.data = { token: "xxxxx" }
      const token = response.data.token;

      // Save token to localStorage
      localStorage.setItem("token", token);

      return token; 
    } 
    catch(error){
      return rejectWithValue(error.response?.data || 'Login failed');
    }
  });

const singin = createSlice({
  name: 'demo',
  initialState: initialValue, 
  reducers: {
  
  },
  extraReducers:(builder) =>{
    builder
    .addCase(signinpage.pending , (state) =>{
      state.loading=true;
      state.error=null;
      
    })
    .addCase(signinpage.fulfilled,(state,action) =>{
      state.loading=false;
      // state.userData=action.payload;
      state.userData="success";
      
    })
    .addCase(signinpage.rejected,(state,action)=>{
      state.loading=false;
      state.error=action.payload;
    })
  }
});

export default singin.reducer;
// export const { increment } = singin.actions; 