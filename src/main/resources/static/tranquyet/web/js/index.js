$(() => {
    $(".checkVideo").click((event) => {
        let id = event.target.id.includes("video_")
            ? event.target.id.replace("video_", "")
            : null;
        if (id != null) {
            getVideoById(id);
        }
    });

    $(".checkTopic").click((event)=>{

    });

    let LINK_GET_VIDEO_BY_ID = "/api/video/get/";
    let LINK_GET_COMMENT_BY_VIDEO = "/api/comment/";
    let idVideo = "1";

    let embeddedData = (data) => {
        $("#link-video-web").attr("src", data.linkVideo);
        $("#title-video").text(data.titleVideo);
        $("#created-date-video").text(data.createdDate);
        $("#created-by-video").text(data.createdBy);
        $("#description-video").html(data.description);
        $("#content-video").html(data.content);
    };

    let embeddedMessage =(data)=>{
        data.map(p=>{
            $("#message-box").append(
                "<div className=\"alert alert-primary\" style=\"padding: 0.10rem 0.5rem; margin-bottom: 5px\" role=\"alert\"> \n"+
                "<span className=\"badge badge-primary text-black\"><p className=\"font-italic\">"+"<strong>"+p.createdDate+"</strong>"+"</p></span> \n"+
                "<p>"+p.messageContent+"</p>"+
                "</div>"+
                "<hr>"
            );
        });
    }

    $("#message-box").empty();
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: LINK_GET_VIDEO_BY_ID + idVideo,
        dataType: "json",
        cache: false,
        success: (data) => {
            console.log(data);
            localStorage.setItem("idVideo", data.id);
            getCommentByVideo(data.id);
            embeddedData(data);
            toastr.success("Save Successfully!");
        },
        error: function (e) {
            console.log(e);
            toastr.error("Couldn't open this video");
        },
    });

    let getCommentByVideo = (id)=>{

        if (id != null && id.length != 0) {
            $("#message-box").empty();
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: LINK_GET_COMMENT_BY_VIDEO + id,
                dataType: "json",
                cache: false,
                success: (data) => {

                    console.log(data);
                    embeddedMessage(data);
                    toastr.success("Load Comments Successfully!");
                },
                error: function (e) {
                    console.log(e);
                    toastr.error("Couldn't Load The Comments");
                },
            });
        }
    };

    let getVideoById = (id) => {
        if (id != null && id.length != 0) {
            $("#message-box").empty();
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: LINK_GET_VIDEO_BY_ID + id,
                dataType: "json",
                cache: false,
                success: (data) => {
                    console.log(data);
                    localStorage.setItem("idVideo", data.id);
                    getCommentByVideo(data.id);
                    embeddedData(data);
                    toastr.success("Successfully!");
                },
                error: function (e) {
                    console.log(e);
                    toastr.error("Couldn't open this video");
                },
            });
        }
    };

    $("#button-love-web").click((e) => {
        e.preventDefault();
        idVideo = 2;
        getVideoById(idVideo);
    });

    $("#topic_genius").click((e) => {
        e.preventDefault();
        toastr.info("Hello");
    });

    $("#topic_funny").click((e) => {
        e.preventDefault();
        toastr.info("Hello");
    });
});

