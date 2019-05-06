<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Available train found</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="1000" style="border-collapse: collapse;">
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Ми знайшли вільні білети на наступні потяги:
            </p>
            <table border="1px solid black">
                <tr>
                    <th><b>Номер</b></th>
                    <th><b>Час відправлення</b></th>
                    <th><b>Час прибуття</b></th>
                    <td><b>Початкова станція</b></th>
                    <th><b>Кінцеіва станція</b></th>
                    <th><b>Кількість місць</b></th>
                </tr>
            <#list trains as train>
                <tr>
                    <td>${train.number}</td>
                    <td>${train.arrival}</td>
                    <td>${train.departing}</td>
                    <td>${train.from}</td>
                    <td>${train.to}</td>
                    <#list train.places as place>
                        ${place.type} : ${place.count}
                    </#list>
                </tr>
            </#list>
            </table>
            <p>Дякую!</p>
        </td>
    </tr>
</table>
</body>
</html>