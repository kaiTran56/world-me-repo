$(()=>{
    let content;
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .then(newContent =>{
            content =  newContent;
        })
        .catch( error => {
            console.error( error );
        } );

    $('#button-check').click((event)=>{
        console.log(content.getData());
        alert(content.getData());
    });

});
