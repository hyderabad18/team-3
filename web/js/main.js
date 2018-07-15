

// Initialize Firebase
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

var cat = document.querySelector('#cat').value;
var edRef;
if(cat == 'education'){
    edRef = db.ref('Events/Education/');
}else if(cat == 'enabled'){
    edRef = db.ref('Events/Enabled/');
}else if(cat == 'environment'){
    edRef = db.ref('Events/Environment/');
}else if(cat == 'health'){
    edRef = db.ref('Events/Health/');
}

document.querySelector('.addValue')
  .addEventListener("click", function( event ) {  
    event.preventDefault();
    if( document.querySelector('#eventName').value != '' || document.querySelector('#location').value != '' ){
        var obj = {
            eventname: document.querySelector('#eventName').value,
            eventlocation: document.querySelector('#location').value,
            startdate: document.querySelector('#startDate').value,
            enddate: document.querySelector('#endDate').value,
            starttime: document.querySelector('#starthours').value + '.'+document.querySelector('#startmins').value + document.querySelector('#startap').value,
            imageurl: "",
            eventdesc: document.querySelector("#description").value,
          };
        edRef.push(obj);
        console.log(obj);
        register_form.reset();
    } else {
      alert('Please fill atlease name or email!');
    }
  }, false);

