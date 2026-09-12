import React from 'react'

const ExpenseForm = () => {
  return (
    <div className='bg-white rounded-2xl shadow-md px-6 py-6 mb-6' >
  
    <h2 className='text-2xl font-semibold text-gray-700 mb-4'>Add Expense</h2>
    <form action="#" className='grid grid-cols-1 md:grid-cols-2 gap-4'>
        {/* title */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Title</label>
            <input type="text" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' />
        </div>


            {/* catagory */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Catagory</label>
          <select name="" id="" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600'>

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
            <input type="text" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' />
        </div>
            {/* date */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Date</label>
            <input type="Date" className='border w-full border-gray-300 rounded-lg
            px-3 py-2  focus:outline-none focus:border-blue-600' />
        </div>

        {/* add expense button */}
        <div className='mt-5'>
            <button className="bg-green-500 hover:bg-green-600  text-white font-semibold px-6 py-3 rounded-xl shadow-md hover:shadow-xl transition-all duration-200">Add Expense</button>
        </div>

    </form>
    </div>
  )
}

export default ExpenseForm