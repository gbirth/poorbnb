<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

</head>
<style>
</style>
<body background="./resources/imagem/bg.png">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light  shadow">
		<a class="navbar-brand" href="#"> <img
			src="./resources/imagem/logo.png" width="200" height="50" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#conteudoNavbarSuportado"
			aria-controls="conteudoNavbarSuportado" aria-expanded="false"
			aria-label="Alterna navegação">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Página
						inicial <span class="sr-only">(página atual)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Sobre</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Anuncie
						seu hotel</a></li>

			</ul>
			<form class="form-inline my-2 my-lg-0">

				<div class="btn-group " role="group" aria-label="Exemplo básico">
					<button type="button" class="btn btn-warning">Cadastrar</button>
					<button type="button" class="btn btn-warning">Entrar</button>
				</div>
			</form>
		</div>
	</nav>


	<!-- Fim navbar -->
	<!-- Cadastro -->
	<p></p>
	<div class="container d-flex justify-content-center">

		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Cadastrar hotel -
					Quartos</h4>
				<hr>
				<p class="text-success text-center">
					<img src="./resources/imagem/logo-2.png" width="94" height="86"
						alt="" id="centro">
				</p>
				<form>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-bed"
									aria-hidden="true"></i></i>
								</span>
							</div>
							<input class="form-control" placeholder="Tipo do quarto"
								type="text"> <input class="form-control"
								placeholder="quantidade disponível" type="number" min="0">

						</div>
						<!-- Preço// -->
						<p></p>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-money"
										aria-hidden="true"></i></i>
									</span>
								</div>
								<input name="" class="form-control"
									placeholder="Preço diária, exemplo: 100,00" type="text">
							</div>
							<!-- preço// -->

							<p></p>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-book"
											aria-hidden="true"></i>
										</span>
									</div>
									<input name="" class="form-control"
										placeholder="Descrição do quarto" type="text">


								</div>
								<!-- CPF// -->

								<!-- imagens -->
								<p></p>
								<p></p>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i>
											</span>
										</div>
										<input name="" class="form-control"
											placeholder="Quantas pessoas acomoda?" type="text">
									</div>

									<!-- imagens -->
									<p></p>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroupFileAddon01">Foto</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input"
												id="inputGroupFile01"
												aria-describedby="inputGroupFileAddon01"> <label
												class="custom-file-label" for="inputGroupFile01">Escolher
												arquivo</label>
										</div>
									</div>
								</div>
								<!-- adicionar// -->
								<p></p>
								<div class="form-group">
									<button type="submit" class="btn btn-warning btn-block">
										Salvar e adicionar outro tipo de quarto <i
											class="fa fa-floppy-o" aria-hidden="true"></i>
									</button>
								</div>
								<!-- adicionar// -->



							</div>
							<!-- form-group// -->
							<div class="form-group">
								<div class="btn-group btn-group-toggle" data-toggle="buttons">
									<label class="btn btn-warning"> <input type="radio"
										name="options" id="option3" autocomplete="off"> <i
										class="fa fa-arrow-left" aria-hidden="true"></i> Voltar
									</label> <label class="btn btn-warning"> <input type="radio"
										name="options" id="option3" autocomplete="off">
										Próximo <i class="fa fa-arrow-right" aria-hidden="true"></i>
									</label>
								</div>
				</form>
			</article>
		</div>
		<!-- card.// -->

		</aside>
		<!-- col.// -->
	</div>
	<!-- row.// -->

	</div>
	<!--container end.//-->



</body>
</html>