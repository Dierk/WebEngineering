<!doctype html>
<html>
<head>
    <title>Awkward Silence</title>
    <style>
        circle, line {
            fill: white;
            stroke: red;
            stroke-width: 3px;
        }
    </style>
</head>
<body>

    <svg width="400" height="400">
        <circle r="198" cx="200" cy="200"/>
        <g:each var="line" in="${lines}">
            <line
                x1="${line.x1}"
                y1="${line.y1}"
                x2="${line.x2}"
                y2="${line.y2}"
                />
        </g:each>
    </svg>

</body>
</html>
