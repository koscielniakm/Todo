function getTasklistRowDiv(id, taskListName) {
  return '<div id="' + id + '">p><span class="fontello icon-list"></span>' + taskListName +'</p></div>';
}


function loadTasks(taskListId) {
  $.ajax({
    url: "http://localhost:8080/TodoWeb/todo/task/tasklist/" + taskListId /* + taskListId*/,
    success: function(data) {
      
      $('#tasks').html('');

      JSON.stringify(data);

      for(let i = 0; i < data.length; i++) { 
        $('#tasks').append(
        '<div class="task" id="' + data[i]['id'] +
        '"><p>' + data[i]['name'] +
        '</p></div>');
      }

  },
    error: function() {
      alert("Error in the request.");
    }
  });
};

function loadTaskListMenu() {
  $.ajax({
    url: "http://localhost:8080/TodoWeb/todo/tasklist/",
    success: function(data) {

      JSON.stringify(data);

      for(let i = 0; i < data.length; i++) { 
        $('#tasklists').append(
        '<div class="sidebar-row-hover tasklist row" id="' + 'tasklist-' + data[i]['id'] +
        '"><p><span class="fontello icon-list"></span>' + data[i]['name'] +
        '</p></div>');
      }

      $('#tasklists').append(
				'<div id="tasklists-add" class="sidebar-row-hover row">' + 
					'<p><span class="fontello icon-plus"></span>Add tasklist ...</p>' +
				'</div>'
      );

      $('.tasklist').each(function() {
        let idContent = $(this).attr('id');
        let taskListId = idContent.substring(9); /* substring 0-8 is : 'tasklist-' */
        $(this).on( "click", function() {
          loadTasks(taskListId);
        });
      });
  },
    error: function() {
      alert("Error in the request.");
    }
  });
};


function assignActionsToTaskListMenu() {

}


loadTaskListMenu();