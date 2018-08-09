var config = {
    apiKey: "AIzaSyDzoYBuUMo00udwwk7h88VIaem4Q2sy_JQ",
    authDomain: "my-project-1531199284038.firebaseapp.com",
    databaseURL: "https://my-project-1531199284038.firebaseio.com",
    projectId: "my-project-1531199284038",
    storageBucket: "my-project-1531199284038.appspot.com",
    messagingSenderId: "481230296994"
};
firebase.initializeApp(config);
  
  
var db = firebase.database();

var userRef = db.ref('Users');

userRef.once("value")
.then(function(snapshot) {
snapshot.forEach(renderSingleSnapshot);
});

var renderSingleSnapshot = function(singleSnapshot){

    var val = singleSnapshot.val();
    /*console.log(singleSnapshot.key, val );
    console.log(val.address);
    console.log(val.date.date_start);
    <div class="card col-sm-3 text-center" style="margin:15px 25px">
        <h4 class="name">Rajath</h4>
        
        <div class="card-body">
            <p class="hours"> No of Hours towards change: <strong>42</strong></p>
            <p class="totalEvents"> No of Events Participated: <strong>7</strong></p>
            <p class="ActiveEvents"> Active Events: <strong>2</strong></p>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star"></span>
            <span class="fa fa-star"></span>
        </div>
        <p class="location">
            Hyderbad <span class="fa fa-map-marker"></span>
        </p>
        <button type="button" class="btn  btn-success" style="margin:10px 5px;" data-toggle="modal" data-target="#details1">Details</button>
    </div>  
  
    
    */
  
    document.querySelector('.volunteers').innerHTML += contactHtmlFromObject(val);
}
  
function contactHtmlFromObject(val){
      console.log(val);
      var html = '';
      html += '<div class="card col-sm-3 text-center" style="margin:15px 25px">';
      html += '<h4 class="name">'+val.name+'</h4>';
      html += '<div class="card-body">';
      html += '<p class="hours"> No of Hours towards change: <strong>' + val.hours + '</strong></p>';
      html += '<p class="totalEvents"> No of Events Participated: <strong>7</strong></p>';
      html += '<p class="ActiveEvents"> Active Events: <strong>2</strong></p>';
      html += '<span class="fa fa-star checked"></span>';
      html += '<span class="fa fa-star checked"></span>';
      html += '<span class="fa fa-star checked"></span>';
      html += '<span class="fa fa-star"></span>';
      html += '<span class="fa fa-star"></span>';
      html += '</div>';
      html += '<p class="location">' + val.location + '<span class="fa fa-map-marker"></span></p>';
      html += '<button type="button" class="btn  btn-success" style="margin:10px 5px;" data-toggle="modal" data-target="#details1">Details</button>';
      html += '</div>';
      return html;
  }