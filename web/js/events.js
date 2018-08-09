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

var edRef = db.ref('Events/Education/');

edRef.once("value")
.then(function(snapshot) {
snapshot.forEach(renderSingleSnapshot);
});

var edRef = db.ref('Events/Environment/');

edRef.once("value")
.then(function(snapshot) {
    snapshot.forEach(renderSingleSnapshot);
});

var edRef = db.ref('Events/Enabled/');

edRef.once("value")
.then(function(snapshot) {
    snapshot.forEach(renderSingleSnapshot);
});

var edRef = db.ref('Events/Health/');

edRef.once("value")
.then(function(snapshot) {
    snapshot.forEach(renderSingleSnapshot);
});





var renderSingleSnapshot = function(singleSnapshot){
  
  var val = singleSnapshot.val();
  /*console.log(singleSnapshot.key, val );
  console.log(val.address);
  console.log(val.date.date_start);
  <div class="card col-sm-3 text-center" style="margin:15px 25px">
        <h4>NMSS</h4>
        <img class="card-img-top" src="http://via.placeholder.com/350x170" alt="Card image cap">
        <div class="card-body">
            <p class="card-text"><strong>Description: </strong>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
        <p class="location">
            Hyderbad <span class="fa fa-map-marker"></span>
        </p>
        <button type="button" class="btn  btn-success" style="margin:10px 5px;" data-toggle="modal" data-target="#details1">Details</button>
    </div>

  
  */

    document.querySelector('.events').innerHTML += contactHtmlFromObject(val);
}

function contactHtmlFromObject(val){
    console.log(val);
    var html = '';
    html+= '<div class="card col-sm-3 text-center" style="margin:15px 25px">';
    html+= '<h4>'+ val.eventname + '</h4>';
    html+= '<img class="card-img-top" src="http://via.placeholder.com/350x170" alt="Card image cap">';
    html+= '<div class="card-body"><p class="card-text"><strong>Description: </strong>' + val.eventdesc +'</p></div>';
    html+= '<p class="location">' + val.eventlocation + '<span class="fa fa-map-marker"></span></p>';
    html+='<button type="button" class="btn  btn-success" style="margin:10px 5px;" data-toggle="modal" data-target="#details1">Details</button>';
    html+='</div>'
    return html;
}

