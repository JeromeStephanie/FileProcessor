'use client'

import { useState } from 'react';
import axios from 'axios';

export default function FileUpload() {
    const [file, setFile] = useState(null);
    const [processedText, setProcessedText] = useState('');

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (file) {
            const formData = new FormData();
            formData.append('file', file);

            const response = await axios.post('http://localhost:8080/process-file', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });


            setProcessedText(response.data);
        }
    };

    return (
        <div className='border bg-white rounded-lg shadow-xl flex flex-col justify-center items-center p-5'>
            <h1 className='mb-4 text-xl font-[590]'>Upload a Text File</h1>
            <form onSubmit={handleSubmit} className='flex justify-between items-center'>
                <input type="file" accept=".txt" onChange={handleFileChange} />
                <button type="submit" className='bg-gray-800 px-5 py-1 rounded-md hover:bg-gray-700 duration-300 text-white font-medium'>Upload</button>
            </form>
            {processedText && (
                <div>
                    <h2 className='font-[590] my-4'>Processed Text:</h2>
                    <pre>{processedText}</pre>
                </div>
            )}
        </div>
    );
}
