//TMDB

const API_KEY = 'api_key=c05a21bfe10d350302868e8098137963';
const BASE_URL ='https://api.themoviedb.org/3';
const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&'+API_KEY;
const IMG_URL= 'https://image.tmdb.org/t/p/w500';

const main = document.getElementById('main');

getMovies(API_URL);

function getMovies(url){

    fetch(url).then(res => res.json()).then(data => {
        showMovies(data.results);
    })
}

function showMovies(data){
    main.innerHTML='';
    i=1
  //  data = data.slice(0,10);
    console.log(data)            //영화 데이터 

    data.forEach(movie =>{
        const{id, title, poster_path, vote_average, overview} = movie;
        const movieE1 = document.createElement('div');
        movieE1.classList.add('movie');

        movieE1.innerHTML = `
        <div id="movie${id}" onclick='goToBoard(${id})' style='cursor:pointer;'>
        <img src="${IMG_URL+poster_path}" alt="${title}">
        
        <div class="movie-info">
            <h3>${title}</h3>
            
          <!-- <span class="${getColor(vote_average)}">${vote_average}</span> -->
        </div>

        <div class="overview">

            <h3>overview</h3>
            ${overview}
        </div>
        </div>`
        main.appendChild(movieE1);
        i=i+1
    });
}


function getColor(vote){
    if(vote>=8){
        return 'green'
    }else if(vote>=5){
        return 'orange'
    }else{
        return 'red'
    }
}

function goToBoard(id){
    location.href= "board/list/movie"+id;
}