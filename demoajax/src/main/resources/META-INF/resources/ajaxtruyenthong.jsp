<%@ include file="init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<portlet:defineObjects />

<portlet:resourceURL var="goiem" id="laembe"></portlet:resourceURL>


<script type="text/javascript">
    $(document).ready(function(){
        $('#send').click(function(event) {
            $.ajax({
                url: '<%= goiem %>',
                type: 'POST',
                dataType: "json",
                data: {
                    firstname : 'Radouane',
                    lastname : 'Roufid',
                    site : 'www.roufid.com'
                },
                success: function(response) {
                    alert(response.message); // Hiển thị message từ response
                },
                error: function(xhr, status, error) {
                    console.log("Error: " + error);
                }
            });
        });
    });
</script>


<form>
	<input type="button" id="send" value="Send">
</form>