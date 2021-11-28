$(()=>{
    let contentVideo;
    let descriptionVideo;
    const URL_SAVE_VIDEO = "/admin/api/video/add";
    let LINK_DELETE_VIDEO = "/admin/api/video/delete/";

    ClassicEditor
        .create( document.querySelector( '#editor-description' ) )
        .then(newContent =>{
            descriptionVideo =  newContent;
        })
        .catch( error => {
            console.error( error );
        } );
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .then(newContent =>{
            contentVideo =  newContent;
        })
        .catch( error => {
            console.error( error );
        } );
    // clear fields
    let clearField =()=>{
        $('#input-title').val('');
        $('#input-link-image').val('');
        $('#input-link-video').val('');
        contentVideo.setData('');
        descriptionVideo.setData('');
    }
    //button-save-movie
    $('#button-save-video').click((event)=>{
        let title = $('#input-title').val();
        let topic = $('#selection-topic').find(":selected").text();
        let linkImage = $('#input-link-image').val();
        let linkVideo = $('#input-link-video').val();
        let content = contentVideo.getData();
        let description =descriptionVideo.getData();

        let movie = {
            titleVideo: title,
            topicDTO: {
                name: topic
            },
            linkVideo: linkVideo,
            linkImage: linkImage,
            content: content,
            description: description
        };
        console.log(movie);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: URL_SAVE_VIDEO,
            data: JSON.stringify(movie),
            dataType: 'json',
            cache: false,
            success:  (data)=> {
                clearField();
                console.log(data);
                toastr.success("Save Successfully!");
            },
            error: function (e) {
                console.log(e);
                toastr.error("Cancel Save Video");
            }
        });
    });

    //button-movie-cancel
    $('#button-video-cancel').click((event)=>{
        clearField();
        toastr.error("Cancel Save Video");
    });

    $('.delete-video').click((event)=>{
        let id = event.target.id.includes("delete_")
            ? event.target.id.replace("delete_", "")
            : null;
        if(id!=null){
            deleteById(id);
            setTimeout(()=>{
                location.reload();
            }, 3000);
        }
    });

    let deleteById =(id)=>{
        if(id!=null&& id.length !=0){
            $.ajax({
                url: LINK_DELETE_VIDEO + id,
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
});
