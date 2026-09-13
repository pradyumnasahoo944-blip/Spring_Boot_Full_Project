import axios from 'axios'
import React, { captureOwnerStack, useState } from 'react'

const ExpenseForm = ({getExpenses}) => {

    const[title,setTitle] =useState('')
    const[category,setCategory] =useState('')
    const[price,setPrice] =useState('')
    const[date,setDate] =useState('')
    const handleSubmit= async(e)=>{
        e.preventDefault();

        if(!validate()) return
        const expense ={
            id:0 ,
            title,
            category,
            price,
            date
        }
        await createExpense(expense)
    }

    async function createExpense(expense){
        try{ 
        const response = await axios.post("http://localhost:8080/expenses",expense)
        if(response.status ===201){
            getExpenses()
            clearForm()
        }else{
            alert("something went wrong")
        }
    }catch(err){
        console.log("some error happen",err);
        
    }
    }

    const[errors,setError] =useState({})
     const newErrors ={}
    const validate =()=>{
        if(!title){
            newErrors.title='Title is missing'
        }else if(title.length<=3){
            newErrors.title ='Title must have atleaast 3 charecter '
        }
    

    if(!category){
        newErrors.category ='Please chose a valid category'
    }
    if(!price || isNaN(price) || price<=0){
        newErrors.price ='Price must be greater than 0'
    }

    if(!date){
        newErrors.date ='Date is required'
    }
    setError(newErrors)
    return Object.keys(newErrors).length === 0 

    }


    const clearForm =()=>{
        setTitle('')
        setCategory('')
        setPrice('')
        setDate('')
    }
    // const handleTitleChange =(e)=>{
    //     console.log("handleTitleChange")
    //     setTitle(e.target.value)
        
    // }

    const handleChange =(e)=>{
        // console.log(e.target.name,'->',e.target.value);
        const{name,value}=e.target

            switch (name) {
            case 'title':
                setTitle(value)
                setError(prev =>({...prev,title:''}))
                break;
                case 'category':
                    setCategory(value)
                    setError(prev =>({...prev,category:''}))
                    
                    break;
            case 'price':
                setPrice(value)
                setError(prev =>({...prev,price:''}))
                
                break;
                case 'date':
                    setDate(value)
                    setError(prev =>({...prev,date:''}))

                
                break;
        
            
        }
        
    }
  return (
    <div className='bg-white rounded-2xl shadow-md px-6 py-6 mb-6' >
  
    <h2 className='text-2xl font-semibold text-gray-700 mb-4'>Add Expense</h2>
    <form onSubmit={handleSubmit} className='grid grid-cols-1 md:grid-cols-2 gap-4'>
        {/* title */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Title</label>
            <input placeholder='eg:-House Rent' type="text" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' onChange={handleChange} name='title' value={title}/>

            {
                errors.title &&(
                    <p className='text-red-500 mt-1 text-sm'>{errors.title}</p>
                )
            }
        </div>


            {/* catagory */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Catagory</label>
          <select id="" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' onChange={handleChange} name ='category' value={category}>
              
            

            <option value="Selected">---Selected category---</option>
            <option value="Food">food</option>
            <option value="Travel">Travel</option>
            <option value="Utilities">Utilities</option>
            <option value="Shoping">Shoping</option>
            <option value="Entertainmaint">Entertainment</option>
            <option value="Health">Health</option>
            <option value="Education">Education</option>
            <option value="Others">Others</option>
            </select>
        </div>
            {/* price */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Price</label>
            <input placeholder='e.g :-100000.00' type="text" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' onChange={handleChange}name='price' value={price}/>

            { 
                 errors.price &&(
                    <p className='text-red-500 mt-1 text-sm'>{errors.price}</p>
                )
            }
        </div>
            {/* date */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Date</label>
            <input type="Date" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' onChange={handleChange}name='date' value={date} />
            { 
                 errors.date &&(
                    <p className='text-red-500 mt-1 text-sm'>{errors.date}</p>
                )
            }
        </div>

        {/* add expense button */}
        <div className='mt-5'>
            <button className="bg-green-500 hover:bg-green-600  text-white font-semibold px-6 py-3 rounded-xl shadow-md hover:shadow-xl transition-all duration-200" >Add Expense</button>
        </div>

    </form>
    </div>
  )
}

export default ExpenseForm