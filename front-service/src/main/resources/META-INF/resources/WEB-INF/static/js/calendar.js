$(function (){
    $(document).ready(async function () {

        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            defaultDate: moment().format("YYYY-MM-DD"),
            editable: true,
            eventLimit: true,
            events: {
                url: '/appointment/all',
                error: function () {
                    alert('there was an error while fetching events!');
                }
            },
            selectable: true,
            selectHelper: true,
            loading: function (bool) {
                $('#loading').toggle(bool);
            }
        });
    });
});