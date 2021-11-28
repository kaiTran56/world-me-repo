$(()=>{

    let LINK_DELETE_TOPIC = "/admin/api/topic/delete/";
    let LINK_SAVE_TOPIC = "/admin/api/topic/save";

    $(".deleteTopic").click((event) => {
        let id = event.target.id.includes("topic-delete-")
            ? event.target.id.replace("topic-delete-", "")
            : null;
        if (id != null) {
            deleteById(id);
            setTimeout(()=>{
                location.reload();
            }, 3000);
        }
    });

    $('#save-topic-button').click((event)=>{
        saveTopic();
        setTimeout(()=>{
            location.reload();
        }, 3000);
    });

    let deleteById =(id)=>{
        if(id!=null&& id.length !=0){
            $.ajax({
                url: LINK_DELETE_TOPIC + id,
                method: 'DELETE',
                contentType: 'application/json',
                success: (result) =>{
                    toastr.success("Delete Successfully!");
                },
                error: (request,msg,error)=> {
                    toastr.error("Can not delete!");
                }
            });
        }
    }

    let saveTopic = ()=>{
        let topic ={
            name: $('#input-topic').val(),
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: LINK_SAVE_TOPIC,
            data: JSON.stringify(topic),
            dataType: 'json',
            cache: false,
            success:  (data)=> {
                $('#input-topic').val('')
                console.log(data);
                toastr.success("Save Successfully!");
            },
            error: function (e) {
                console.log(e);
                toastr.error("Cancel Save!");
            }
        });
    };

});