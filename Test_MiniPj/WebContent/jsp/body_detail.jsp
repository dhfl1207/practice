<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="../css/body_detail.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<main class="container" align="center">
		<div class="row mb-2">
			<div class="col-md-12">
				<div
					class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col-auto d-lg-block">
						<svg class="bd-placeholder-img" width="200" height="250"
							xmlns="http://www.w3.org/2000/svg" role="img"
							aria-label="Placeholder: Thumbnail"
							preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
								fill="#55595c" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

					</div>
					<div class="col p-4 d-flex flex-column position-static"
						align="left">
						<strong class="d-inline-block mb-2 text-primary">장르</strong>
						<h3 class="mb-0">웹툰 이름</h3>
						<div class="mb-1 text-muted">작가 이름</div>
						<p class="card-text mb-auto">별점</p>
						<p class="stretched-link">키워드</p>
						<div align="right">
							<button class="button">보러가기 →</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</main>

	<main class="container" align="left">
		<div class="row mb-2">
			<div class="col-md-12">
				<div
					class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">

					<div class="col p-4 d-flex flex-column position-static">
						<h5 class="mb-0">후기 남기기</h5>
						<br/>
						<div style="float:left; margin-right:10px;">
						<textarea id="story" name="story" rows="5" style="width:100%;" id="textarea">리뷰를 남겨보세요</textarea> 
						</div>
						<button class="button">리뷰 등록</button>
						
						<div>
							<button class="keyword_b">키워드1</button>
							<button class="keyword_b">키워드2</button>
							<button class="keyword_b">키워드3</button>
							<button class="keyword_b">키워드4</button>
							<button class="keyword_b">키워드5</button>
							<button class="keyword_b">키워드6</button>
							<button class="keyword_b">키워드7</button>
							<button class="keyword_b">키워드8</button>
							<button class="keyword_b">키워드9</button>
							<button class="keyword_b">키워드10</button>
							<button class="keyword_b">키워드11</button>
							<button class="keyword_b">키워드12</button>
							<button class="keyword_b">키워드13</button>
							<button class="keyword_b">키워드14</button>
							<button class="keyword_b">키워드15</button>
							<button class="keyword_b">키워드16</button>
							<button class="keyword_b">키워드17</button>
							<button class="keyword_b">키워드18</button>
							<button class="keyword_b">키워드19</button>
							<button class="keyword_b">키워드20</button>
						</div>

					</div>

				</div>
			</div>
		</div>
	</main>
	
	<main class="container" align="center">
		<div class="row mb-2">
			<div class="col-md-12">
				<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static" align="left">
						<h5 class="mb-0">다른 사람들은?</h5>
						
						<div class="">
							<ul>
								<li>
									<div>
									실질적인 내용이 들어갈 거에요 
									</div>
									<div>
										<button>댓글 추천</button>
									</div>
								
								</li>
							</ul>
							
						</div>
						
					</div>

				</div>
			</div>
		</div>
	</main>
</body>
</html>