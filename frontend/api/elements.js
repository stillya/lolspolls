import axios from 'axios'

const uri = process.env.REACT_APP_API_URI + process.env.REACT_APP_API_PREFIX

export function requestElements(questionId) { 
    return axios
        .get(
            uri + '/element' + questionId
        ).then((request) => request.data)
}

export function requestCreateElement(element) { 
    return axios
        .post(
            uri + '/element', 
            {...element}
        ).then((request) => request.data)
}

export function requestUpdateElement(element) { 
    return axios
        .put(
            uri + '/element/update', 
            {...element}
        ).then((request) => request.data)
}