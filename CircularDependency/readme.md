Because of the circular dependency one service class being dependent on the other
circular dependency error is thrown.

APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

┌─────┐
|  feedBackService defined in file [C:\Programming\Spring-Boot-Projects\CircularDependency\target\classes\com\content\negotitation\CircularDependency\service\FeedBackService.class]
↑     ↓
|  scheduleService defined in file [C:\Programming\Spring-Boot-Projects\CircularDependency\target\classes\com\content\negotitation\CircularDependency\service\ScheduleService.class]
└─────┘

Rectification is done with the help of @Lazy annotation which creates a proxy of one of the bean and injects it.
or use a field or setter injection. 