import { useObserver } from "mobx-react-lite";
import MainHeader from "./commons/MainHeader";

function QuestionList() {


    return useObserver(() => {
        return (
            <MainHeader />
        )
    })

}

export default QuestionList;