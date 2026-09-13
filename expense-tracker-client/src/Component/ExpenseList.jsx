
import axios from 'axios'
import React, { useEffect, useState } from 'react'

const ExpenseList = ({expenses, getExpenses}) => {

      

       
        const handleDelete =async(expenseId)=>{
          if(confirm("Are u sure want to delete the expenses")){
          try {
             const response =await axios.delete('http://localhost:8080/expenses/'+expenseId)
             if(response.status ==204){
              getExpenses()
             }else{
              alert("Unable to delete the expense")
             }
          } catch (error) {
            console.log("Some Errro Occured:-",error);
            
          } 
          }
        }
      


  return (
    <div className='bg-white rounded-2xl shadow-md px-6 py-6 mb-6'>

      <h2 className='text-2xl font-semibold text-gray-700 mb-4'>
        Expense List
      </h2>


      <div className='overflow-x-auto'>
        {/* it put becoz to avoid overflow property in table  */}
      <table className='w-full text-sm text-left'>

        <thead>
          <tr className='bg-gray-100 text-gray-600 uppercase text-xs font-semibold'>
            <th className='px-4 py-3'>#</th>
            <th className='px-4 py-3'>Title</th>
            <th className='px-4 py-3'>Category</th>
            <th className='px-4 py-3'>Price</th>
            <th className='px-4 py-3'>Date</th>
            <th className='px-4 py-3 text-center'>Action</th>
          </tr>
        </thead>

        <tbody>
        {
           ! expenses.length?
              <tr><td colSpan={6}className='text-center text-gray-400 py-2 font-medium italic'>No data found
              </td></tr> :
          expenses.map((exp,idx)=>(
            
            
          <tr key={exp.id} className='border-b border-gray-200 hover:bg-gray-50 transition-colors'>
              
            <td className='px-4 py-3 text-gray-400'>
              {idx+1}
            </td>

            <td className='px-4 py-3 text-gray-700 font-medium'>
             {exp.title}
            </td>

            <td className='px-4 py-3'>
              <span className='bg-blue-100 text-blue-700 font-semibold rounded-full px-2 py-1 text-xs'>
              {exp.category}
              </span>
            </td>

            <td className='px-4 py-3 font-semibold text-gray-700'>
              {exp.price}
            </td>

            <td className='px-4 py-3 text-gray-600'>
             {exp.date}
            </td>

            <td className='px-4 py-3 text-center'>

              <button className='bg-yellow-400 hover:bg-yellow-500 text-white font-semibold rounded-lg px-3 py-1.5 transition-colors duration-200 text-xs mr-2'>
                Edit
              </button>

              <button onClick={()=>handleDelete(exp.id)} className='bg-red-400 hover:bg-red-500 text-white font-semibold rounded-lg px-3 py-1.5 transition-colors duration-200 text-xs'>
                Delete
              </button>

            </td>

          </tr>


          ) )
        }
      
        </tbody>
      
      
      </table>

      </div>


    </div>
  )
}

export default ExpenseList