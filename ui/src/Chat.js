import React, { useState } from 'react';
import axios from 'axios';
import config from './config';

const Chat = () => {
    const [question, setQuestion] = useState('');
    const [answer, setAnswer] = useState('');
    const [loading, setLoading] = useState(false);

    const handleAskQuestion = async () => {
        setLoading(true);
        try {
            const { data } = await axios.post(`${config.apiUrl}/api/ask`, { question }, {
                headers: { 'Content-Type': 'application/json' },
            });
            setAnswer(data);
        } catch (error) {
            setAnswer(`Error: ${error.message}`);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="container">
            <h1 className="mt-5">Chat with Azure AI</h1>
            <div className="form-group">
                <label htmlFor="question">Question:</label>
                <input
                    type="text"
                    className="form-control"
                    id="question"
                    value={question}
                    onChange={(e) => setQuestion(e.target.value)}
                />
            </div>
            <button className="btn btn-primary mt-3" onClick={handleAskQuestion} disabled={loading}>
                Ask
            </button>
            {loading && <div className="mt-3"><i className="fas fa-spinner fa-spin"></i></div>}
            <div className="mt-3">
                <h3>Answer:</h3>
                <p>{answer}</p>
            </div>
        </div>
    );
};

export default Chat;