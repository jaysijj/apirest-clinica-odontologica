CREATE TABLE `tb_consultas` (
  `id` bigint(20) NOT NULL,
  `id_paciente` bigint(20) NOT NULL,
  `id_dentista` bigint(20) NOT NULL,
  `data_consulta` datetime NOT NULL,
  `descricao` varchar(255) NOT NULL
  -- CONSTRAINT `FK_tb_consulta_tb_usuario_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `tb_usuario` (`id`),
  -- CONSTRAINT `FK_tb_consulta_tb_dentista_dentista` FOREIGN KEY (`id_dentista`) REFERENCES `tb_dentista` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_consultas`
--
ALTER TABLE `tb_consultas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_consultas`
--
ALTER TABLE `tb_consultas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
