import { MenuItem } from '../models/menu.model';

export class Menu {
  public static pages: MenuItem[] = [
    {
      //tenia el name de base

      group: '',
      separator: false,
      items: [
    
        {
          icon: 'assets/icons/heroicons/outline/id-insignia.svg',
          label: 'GIN',
          route: '/id-insignia',
        },
        {
          icon: 'assets/icons/heroicons/outline/user-circle.svg',
          label: 'Nombre',
          route: '/user-circle',
        },
        
        {
          icon: 'assets/icons/heroicons/outline/usuarios.svg',
          label: 'Subgrupo',
          route: '/usuarios',
        },
        {
          icon: 'assets/icons/heroicons/outline/informacion.svg',
          label: 'Status',
          route: '/informacion',
        },
        {
          icon: 'assets/icons/heroicons/outline/marca-de-calendario.svg',
          label: 'Bench',
          route: '/marca-de-calendario',
        },
        {
          icon: 'assets/icons/heroicons/outline/lectura-de-codigo-de-barras.svg',
          label: 'Das',
          route: '/lectura-de-codigo-de-barras',
        },
        {
          icon: 'assets/icons/heroicons/outline/construccion-de-casas.svg',
          label: 'Ciudad',
          route: '/construccion-de-casas',
        },
        {
          icon: 'assets/icons/heroicons/outline/organigrama.svg',
          label: 'Line_manager',
          route: '/organigrama',
        },
        {
          icon: 'assets/icons/heroicons/outline/tiempo-de-negocios.svg',
          label: 'Jornada',
          route: '/tiempo-de-negocios',
        },
        {
          icon: 'assets/icons/heroicons/outline/money-cheque-editar-alt.svg',
          label: 'GCM',
          route: '/money-cheque-editar-alt',
        },
        {
          icon: 'assets/icons/heroicons/outline/categoria.svg',
          label: 'Categoría',
          route: '/categoria',
        },
        // NIVELGCM   SCR (+iud)   CC   CCNAME 
        {
          icon: 'assets/icons/heroicons/outline/dinero-calculadora.svg',
          label: 'NivelGCM',
          route: '/dinero-calculadora',
        },  
        {
          icon: 'assets/icons/heroicons/outline/mano-sosteniendo-usd.svg',
          label: 'SCR (+iud)',
          route: '/mano-sosteniendo-usd',
        },  
        {
          icon: 'assets/icons/heroicons/outline/codigo-de-barras-rectangulo.svg',
          label: 'CC',
          route: '/codigo-de-barras-rectangulo',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/departamento.svg',
          label: 'CCName',
          route: '/departamento',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/visita.svg',
          label: 'Grupo',
          route: '/visita',
        },  
        {
          icon: 'assets/icons/heroicons/outline/navegador.svg',
          label: 'N_4',
          route: '/navegador',
        },  
        {
          icon: 'assets/icons/heroicons/outline/departamento (1).svg',
          label: 'Agrupacion',
          route: '/departamento (1)',
        },  
        {
          icon: 'assets/icons/heroicons/outline/computadora.svg',
          label: 'Job Technology',
          route: '/computadora',
        },  
        {
          icon: 'assets/icons/heroicons/outline/dispositivos.svg',
          label: 'Job Technology Profile',
          route: '/dispositivos',
        },  
        {
          icon: 'assets/icons/heroicons/outline/mostrar-codigo.svg',
          label: 'Skills',
          route: '/mostrar-codigo',
        },  
        {
          icon: 'assets/icons/heroicons/outline/maleta-alternativa.svg',
          label: 'Role',
          route: '/maleta-alternativa',
        },  
        {
          icon: 'assets/icons/heroicons/outline/comenta-alt-check.svg',
          label: 'RLT',
          route: '/comenta-alt-check',
        },  
        {
          icon: 'assets/icons/heroicons/outline/idioma.svg',
          label: 'SkLanguage',
          route: '/dashboard',
          children: [
            { label: 'A1', route: '/dashboard/nfts' },
            { label: 'A2', route: '/dashboard/nfts' },
            { label: 'B1', route: '/dashboard/nfts' },
            { label: 'B2', route: '/dashboard/nfts' },
            { label: 'C1', route: '/dashboard/nfts' },
            { label: 'C2', route: '/dashboard/nfts' },
          ],
        },
        {
          icon: 'assets/icons/heroicons/outline/linea-de-tiempo-de-la-lista.svg',
          label: 'SkMethods',
          route: '/linea-de-tiempo-de-la-lista',
        },  
        {
          icon: 'assets/icons/heroicons/outline/usuario-robot.svg',
          label: 'SkTechSkills',
          route: '/usuario-robot',
        },  
        {
          icon: 'assets/icons/heroicons/outline/funciones-alternativas.svg',
          label: 'SkCertif',
          route: '/funciones-alternativas',
        },  
        {
          icon: 'assets/icons/heroicons/outline/codigo-de-la-computadora-portatil.svg',
          label: 'SkTechnologies',
          route: '/dashboard',
          children: [
            { label: 'Novice (1)', route: '/dashboard/nfts' },
            { label: 'Junior (2)', route: '/dashboard/nfts' },
            { label: 'Proficient (3)', route: '/dashboard/nfts' },
            { label: 'Senior (4)', route: '/dashboard/nfts' },
            { label: 'Expert (5)', route: '/dashboard/nfts' },
          ],
        },
        {
          icon: 'assets/icons/heroicons/outline/comentarios-dolar.svg',
          label: 'SkBusSkills',
          route: '/comentarios-dolar',
        },  
        
        // {
        //   icon: 'assets/icons/heroicons/outline/lock-closed.svg',
        //   label: 'Auth',
        //   route: '/auth',
        //   children: [
        //     { label: 'Sign up', route: '/auth/sign-up' },
        //     { label: 'Sign in', route: '/auth/sign-in' },
        //     { label: 'Forgot Password', route: '/auth/forgot-password' },
        //     { label: 'New Password', route: '/auth/new-password' },
        //     { label: 'Two Steps', route: '/auth/two-steps' },
        //   ],
        // },
      ],
    },
    // {
    //         //tenia el name de collaboration

    //   group: '',
    //   separator: true,
    //   items: [
    //     {
    //       icon: 'assets/icons/heroicons/outline/download.svg',
    //       label: 'Download',
    //       route: '/download',
    //     },
    //     {
    //       icon: 'assets/icons/heroicons/outline/gift.svg',
    //       label: 'Gift Card',
    //       route: '/gift',
    //     },
    //     {
    //       icon: 'assets/icons/heroicons/outline/users.svg',
    //       label: 'Users',
    //       route: '/users',
    //     },
    //   ],
    // },
   
  ];
}
