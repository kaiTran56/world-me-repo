$(()=>{
   $('#button-comment').click((e)=>{
      toastr.info('Hello World', 'Hey');
   });
   $('#button-comment').click((e)=>{
      toastr.error('Hello World', 'Hey');
   });
});