CREATE TABLE `tb_usuario` (
  `id` bigint(20) NOT NULL,
  `nome_usuario` varchar(255) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `papel` enum('paciente', 'dentista') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `user`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_tb_usuario_cpf` (`cpf`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `tb_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
