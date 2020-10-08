<html>
<head> <title> </title> </head>
<body>
This is jsp test page
<%System.out.println("This is jsp code");
 int i = 2;
 int j = 3;
 int sum = i +j;
 System.out.println("i value is" + i);
 System.out.println("j value is" + j);
 System.out.println("sum value is" + sum);
 %>
 <br/>
 <font color=red> the value of i is </font><%= i %> <br/>
 <font color=red> the value of j is </font>  <%= j %> <br/>
 <font color=red> the value of sum is </font>    <%= sum %> <br/>
 

</body>
</html>