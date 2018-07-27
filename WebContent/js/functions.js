function getTasklistRowDiv(id, taskListName) {
  return '<div id="' + id + '">p><span class="fontello icon-list"></span>' + taskListName +'</p></div>';
}

function loadTaskListMenu() {
  $.ajax({
    url: "http://localhost:8080/TodoWeb/todo/tasklist/",
    success: function(data) {
      JSON.stringify(data);
      for(let i = 0; i < data.length; i++) { 
        $('#tasklists').append(
        '<div class="sidebar-row-hover row" id="' + data[i]['id'] +
        '"><p><span class="fontello icon-list"></span>' + data[i]['name'] +
        '</p></div>');
      }
  },
    error: function() {
      alert("Error in the request.");
    }
  });
};

loadTaskListMenu();