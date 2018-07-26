$('#btn').click(function(){
  $.ajax({
    url: "http://localhost:8080/TodoWeb/todo/tasklist/",
    success: function(data) {
      JSON.stringify(data);
      $("#result").append(JSON.stringify(data));
  },
    error: function() {
      alert("Error in the req+uest.");
    }
  });
});