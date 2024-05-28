import { MenuItem } from '../models/menu.model';

export class Menu {
  public static pages: MenuItem[] = [
    {
      //tenia el name de base

      group: '',
      separator: false,
      items: [
    
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'GIN',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Nombre',
          route: '/gift',
        },
        
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Subgrupo',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Status',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Bench',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Das',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Ciudad',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Line_manager',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Jornada',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'GCM',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Categoría',
          route: '/gift',
        },
        // NIVELGCM   SCR (+iud)   CC   CCNAME 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'NivelGCM',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SCR (+iud)',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'CC',
          route: '/gift',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'CCName',
          route: '/gift',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Grupo',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'N_4',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Agrupacion',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Job Technology',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Job Technology Profile',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Skills',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Role',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'RLT',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/chart-pie.svg',
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
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SkMethods',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SkTechSkills',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SkCertif',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/chart-pie.svg',
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
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SkBusSkills',
          route: '/gift',
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
