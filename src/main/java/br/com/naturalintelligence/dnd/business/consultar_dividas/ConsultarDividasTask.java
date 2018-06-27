package br.com.naturalintelligence.dnd.business.consultar_dividas;

//@Component
public class ConsultarDividasTask //extends TaskImpl implements ConsultarDividasTaskVarMapping
{
//
//    @Autowired
//    private DividaRepository dividaRepo;
//    
//    @Autowired
//    private Mapper modelMapper;
//    
//    @Override
//    public void executar() throws Exception{
//        System.out.println("----->ConsultarDividas");
//        
//        Set<ReguaPosicaoDto> vencimentos = new HashSet<>(getInputVencimentosRegua());
//        Set<Devedor> devedores = new HashSet<>(consultarDevedores(vencimentos));
//        
////      FIXME: implementar conversao entre collections de dtos pra entities e vice-versa?
//        Set<CharacterDto> devedoresDtos = new HashSet<>();
//        devedores.forEach(d -> devedoresDtos.add(modelMapper.map(d, CharacterDto.class)));
//        
//        vincularDividasAsPosicoesDaRegua(devedoresDtos, vencimentos);
//        
//        setOutputDevedoresDtos(Variaveis.DEVEDORES_DTOS, devedoresDtos);
//    }
//    
//    
//    
//    
//    
//    private void vincularDividasAsPosicoesDaRegua(Set<CharacterDto> devedores, Set<ReguaPosicaoDto> posicoes) {
//        for (ReguaPosicaoDto p: posicoes) {
//            for (CharacterDto d: devedores) {
//                for (InstanciaProdutoDto i: d.getInstanciasProdutos()) {
//                    for (DividaDto div: i.getDividas()) {
//                        if (DateUtils.isSameDay(p.getPosicaoAsDate(), div.getDiaVencimento())) {
//                            div.setPosicaoRegua(p);
//                            p.getDividas().add(div);
//                        }
//                    }
//                    
//                }
//            }
//        }
//    }
//
//    private List<Divida> consultarDividasPorDiaVencimento(Set<Date> vencimentos){
//        List<Divida> retorno = dividaRepo.findByDiaVencimentoIn(new ArrayList<>(vencimentos));
//        return retorno;
//    }
//    
//    private Set<Date> extrairVencimentos(Set<ReguaPosicaoDto> posicoes){
//        return posicoes.stream()
//                       .map(ReguaPosicaoDto::getPosicaoAsDate)
//                       .collect(Collectors.toSet());
//    }
//    
//    private Set<Devedor> consultarDevedores(Set<ReguaPosicaoDto> vencimentos){
//        Set<Devedor> devedores = new HashSet<>();
//        List<Divida> dividas = consultarDividasPorDiaVencimento(extrairVencimentos(vencimentos));
//        for (Divida d: dividas) {
//            devedores.add(d.getInstanciaProduto().getDevedor());
//            d.getInstanciaProduto().getDividas().retainAll(dividas);
//        }
//        return new HashSet<>(devedores);
//    }
//    
//

}
