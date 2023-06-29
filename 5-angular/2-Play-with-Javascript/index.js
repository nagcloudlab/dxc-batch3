
const Rx = require('rxjs')

const stream = new Rx.Subject() // Observable Stream

//----------------------------------------------------
// Trainer Module  ( event / data publisher)
//----------------------------------------------------

const trainer = {
    isStreaming: false,
    getTopics: function () {
        let topic = 0;
        if (!this.isStreaming) {
            this.isStreaming = true;
            let interval = setInterval(() => {
                ++topic;
                console.log("trainer : propagating change/event/data into stream");
                stream.next(topic);
                if (topic === 8) {
                    stream.complete();
                    clearInterval(interval)
                }
                // if (topic === 5) {
                //     stream.error("Network is down")
                //     clearInterval(interval)
                // }
            }, 2000);
        }
        return stream;
    }
}


//----------------------------------------------------
// Employee Module ( event / data subscriber)
//----------------------------------------------------

const employee1 = {
    doLearn: function () {
        const stream = trainer.getTopics()
        stream.subscribe({
            next: (topic) => {
                console.log("employee1 : received/reacting topic : " + topic);
            },
            error: (err) => {
                console.log("employee1 : error : " + err);
            },
            complete: () => {
                console.log("employee1 : thanks trainer for all topics");
            }
        })
    }
}

const employee2 = {
    doLearn: function () {
        const stream = trainer.getTopics()
        stream
            .pipe(Rx.filter((topic) => topic % 2 === 0))
            .pipe(Rx.map((topic) => topic * 2))
            .subscribe({
                next: (topic) => {
                    console.log("employee2 : received/reacting topic : " + topic);
                },
                error: (err) => {
                    console.log("employee2 : error : " + err);
                },
                complete: () => {
                    console.log("employee2 : thanks trainer for all topics");
                }
            })
    }
}


employee1.doLearn();

setTimeout(() => {
    employee2.doLearn();
}, 4000);