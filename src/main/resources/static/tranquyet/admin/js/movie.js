$(()=>{
    let contentVideo;
    let descriptionVideo;
    const URL_SAVE_VIDEO = "/admin/api/video/add";
    let LINK_DELETE_VIDEO = "/admin/api/video/delete/";
    let LINK_GET_VIDEO_ADMIN_BY_ID = "/admin/api/video/get/";

    ClassicEditor
        .create( document.querySelector( '#editor-description' ) )
        .then(newContent =>{
            descriptionVideo =  newContent;
        })
        .catch( error => {
            // toastr.error( error );
        } );
    ClassicEditor
        .create( document.querySelector( '#editor' ))
        .then(newContent =>{
            contentVideo =  newContent;
        })
        .catch( error => {
            // toastr.error( error );
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
    ////////////////////////////////
    /////////EDIT VIDEO////////////
    //////////////////////////////

    let clearFieldDetail =()=>{
        $('#title-video-detail-admin').val('');
        $('#image-video-detail-admin').val('');
        $('#link-video-detail-admin').val('');
        $('#content-video-detail-admin').val('');
        $('#description-video-detail-admin').val('');
    }

    let embeddedVideo=(data)=>{
        $('#title-video-detail-admin').val(data.titleVideo);
        $('#image-video-detail-admin').val(data.linkImage);
        $('#link-video-detail-admin').val(data.linkVideo);
        $('#content-video-detail-admin').val(data.content);
        $('#description-video-detail-admin').val(data.description);
    }
    let getId = 0;
    let getVideoById = (id)=>{
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: LINK_GET_VIDEO_ADMIN_BY_ID + id,
            dataType: "json",
            cache: false,
            success: (data) => {
                getId = data.id;
                embeddedVideo(data);
            },
            error: function (e) {
                console.log(e);
                toastr.error("Couldn't open this video");
            },
        });
    };

    $('.detail-video').click((event)=>{
        let id = event.target.id.includes("detail_")
            ? event.target.id.replace("detail_", "")
            : null;
        console.log("show id"+id);
        if(id!=null){
            getVideoById(id);
            // setTimeout(()=>{
            //     location.reload();
            // }, 3000);
        }
    });

    //save-edit-movie
    $('#save-video-detail-admin').click((event)=>{
        let id = getId;
        let title = $('#title-video-detail-admin').val();
        let topic = $('#topic-video-detail-admin').find(":selected").text();
        let linkImage = $('#image-video-detail-admin').val();
        let linkVideo = $('#link-video-detail-admin').val();
        let content = $('#content-video-detail-admin').val();
        let description =$('#description-video-detail-admin').val();

        let movie = {
            id: id,
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
                clearFieldDetail();
                console.log(data);
                toastr.success("Edit Successfully!");
            },
            error: function (e) {
                console.log(e);
                toastr.error("Cancel Not Edit Video");
            }
        });
        setTimeout(()=>{
            location.reload();
        }, 3000);
    });
});
