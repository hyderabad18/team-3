

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
    edRef = db.ref('my_event/education/');
}else if(cat == 'enabled'){
    edRef = db.ref('my_event/enabled/');
}else if(cat == 'environment'){
    edRef = db.ref('my_event/environment/');
}else if(cat == 'health'){
    edRef = db.ref('my_event/health');
}

document.querySelector('.addValue')
  .addEventListener("click", function( event ) {  
    event.preventDefault();
    if( document.querySelector('#eventName').value != '' || document.querySelector('#location').value != '' ){
        var obj = {
            event_name: document.querySelector('#eventName').value,
            address: document.querySelector('#location').value,
            date: {
              date_start: document.querySelector('#startDate').value,
              date_end: document.querySelector('#endDate').value,
            },
            time: {
                startTime: document.querySelector('#starthours').value + '.'+document.querySelector('#startmins').value + document.querySelector('#startap').value,
                endTime: document.querySelector('#endhours').value + '.'+document.querySelector('#endmins').value + document.querySelector('#endap').value,
            },
            event_image: document.querySelector('#imgInp').value,
            no_helped:0,
            no_hrs: 0,
          };
        edRef.push(obj);
        console.log(obj);
        //contactForm.reset();
    } else {
      alert('Please fill atlease name or email!');
    }
  }, false);

