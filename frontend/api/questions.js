import axios from 'axios'

const uri = process.env.REACT_APP_API_URI + process.env.REACT_APP_API_PREFIX

export function requestQuestions(pollId) {
    return axios
        .get(
            uri + '/question/' + pollId
        ).then((request) => request.data)
}

export function requestCreateQuestion(question) {
    return axios
        .post(
            uri + '/question/', 
            {...question}
        ).then((request) => request.data)
}

// export function requestDeleteQuestion(question) {
//     return axios
//         .delete(
//             uri + '/question/' + question.id
//         ).then((request) => request.id)
// }

export function requestUpdateQuestion(question) { 
    return axios
        .put(
            uri + '/question/update/', 
            {...question}
        ).then((request) => request.data)
}