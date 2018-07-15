document.querySelector('.accept')
  .addEventListener("click", function( event ) {  
    event.preventDefault();
    document.querySelector('.accept').innerHTML = "Accepted";
    document.querySelector('.reject').style.display="none";
}, false);





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
    
    
    //var key = Object.keys(snapshot.val())[0];
    //console.log(key)

    snapshot.forEach(renderSingleSnapshot);
});


var renderSingleSnapshot = function(singleSnapshot){

    key = singleSnapshot.key
    //var key = singleSnapshot
    //console.log(Object.keys(singleSnapshot.val())[0]);
    var val = singleSnapshot.val();
    //console.log(key);
    console.log(val);
    //console.log(val);
    /*console.log(singleSnapshot.key, val );
    console.log(val.address);
    console.log(val.date.date_start);
    <div class="card col-sm-3 text-center" style="margin:15px 25px"> 
        <div class="card-body">
            <h4 class="name">Rajath</h4>
            <p class="hours"><strong>Volunteer Location:   </strong> Hyderabad <span class="fa fa-map-marker"></span></p>
            <p class="totalEvents"> <strong>Event</strong>: NMSS</p>
            <p class="location">
                    <strong>Event Location</strong>: Hyderabad <span class="fa fa-map-marker"></span>
            </p>
        </div>
        <button type="button" class="btn  btn-success accept" style="margin: 5px 5px"><span class="fa fa-check"></span>Accept</button>
        <button type="button" class="btn btn-danger reject" style="margin:5px 5px"><span class="fa fa-times"></span>Reject</button>
    </div> 
    
    
    */

    //console.log(val.pending);




//console.log('*******************************');    
for (event in val.pending){
  //      console.log(event);
    //    console.log(val.pending[event]);
        if(val.pending[event].status == '0'){
            document.querySelector('.requests').innerHTML += contactHtmlFromObject(val, val.pending[event], key, event);
          }
    }
    /*val.pending.forEach(function(event){
        console.log(event);
        if(event.status == '0'){
            document.querySelector('.requests').innerHTML += contactHtmlFromObject(val);
          }
    })*/


    
  }
  
  function contactHtmlFromObject(val, data, key, event){
      console.log('*******************');
      console.log(data);
      console.log("------------------------");
      console.log(key);
      console.log(event);
      console.log("------------------------")
      var html = '';
      html += '<div class="card col-sm-3 text-center" style="margin:15px 25px">';
      html += '<div class="card-body">';
      html += '<h4 class="name">' + val.name + '</h4>';
      html += '<span id="user_id" value='+key+' style="visibility:hidden"></span>';
      html += '<span id="event_id" value='+event+' style="visibility:hidden"></span>';
      html += '<p class="hours"><strong>Volunteer Location:   </strong>' + val.location + '<span class="fa fa-map-marker"></span></p>';
      html += '<p class="totalEvents"> <strong>Event</strong>:' + data.eventname + '</p>';
      html += '<p class="location"><strong>Event Location</strong>: ' + data.eventlocation + '<span class="fa fa-map-marker"></span></p>';
      html += '</div>';
      html += '<button type="button" class="btn  btn-success accept" style="margin: 5px 5px"><span class="fa fa-check"></span>Accept</button>';
      html += '<button type="button" class="btn btn-danger reject" style="margin:5px 5px"><span class="fa fa-times"></span>Reject</button>';

      return html;
  }


























document.querySelector('.accept')
  .addEventListener("click", function( event ) {  
    event.preventDefault();
    document.querySelector('.accept').innerHTML = "Accepted";
    document.querySelector('.reject').style.display="none";
}, false);