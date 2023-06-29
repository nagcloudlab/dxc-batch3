

//-----------------------------------------------------
// DOM API
//-----------------------------------------------------


const card = document.querySelector('.card');
const cardBody = document.querySelector('.card-body');
const cardTitle = document.querySelector('.card-title');
const greetBtn = document.querySelector('.btn-primary');
const hideBtn = document.querySelector('.btn-danger');
const showBtn = document.querySelector('.btn-success');

greetBtn.addEventListener('click', (event) => {
    cardBody.innerText = "good morning";
});

hideBtn.addEventListener('click', (event) => {
    card.style.display = 'none';
});

showBtn.addEventListener('click', (event) => {
    card.style.display = 'block';
});


//-----------------------------------------------------
// DOM API + Timer Api
//-----------------------------------------------------


setInterval(() => {
    const timeNowEle = document.querySelector('#time-now');
    timeNowEle.innerText = new Date().toLocaleTimeString('en-US', { timeZone: "Asia/Kolkata" });
}, 1000);


//-----------------------------------------------------



//-----------------------------------------------------
// DOM API + XHR/Fetch Api
//-----------------------------------------------------

const top5TodosBtn = document.querySelector('#top5-todos-btn');
const todosTableBody = document.querySelector('#todos');


top5TodosBtn.addEventListener('click', (event) => {

    const promise = fetch('https://jsonplaceholder.typicode.com/todos?_limit=5')
    promise
        .then(response => response.json())
        .then(data => {
            data.map(todo => {
                todosTableBody.innerHTML += `
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.title}</td>
                    <td>${todo.completed}</td>
                </tr>
                `
            })
        })
})

