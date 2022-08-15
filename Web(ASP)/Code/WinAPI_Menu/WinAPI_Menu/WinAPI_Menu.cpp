// WinAPI_Menu.cpp : Defines the entry point for the application.
//

#include "framework.h"
#include "WinAPI_Menu.h"
#include "Resource.h"

#define MAX_LOADSTRING 100

// Global Variables:
HINSTANCE hInst;                                // current instance
WCHAR szTitle[MAX_LOADSTRING];                  // The title bar text
WCHAR szWindowClass[MAX_LOADSTRING];            // the main window class name

// Forward declarations of functions included in this code module:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);
HMENU menuMain;
HMENU menuVN;

int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);

    // TODO: Place code here.

    // Initialize global strings
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_WINAPIMENU, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // Perform application initialization:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_WINAPIMENU));

    MSG msg;

    // Main message loop:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  FUNCTION: MyRegisterClass()
//
//  PURPOSE: Registers the window class.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW | CS_DBLCLKS;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_MAIN));
    wcex.hCursor        = LoadCursor(hInstance, MAKEINTRESOURCE(IDC_POINTER));
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = NULL;
    wcex.lpszClassName  = szWindowClass;
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

    return RegisterClassExW(&wcex);
}

//
//   FUNCTION: InitInstance(HINSTANCE, int)
//
//   PURPOSE: Saves instance handle and creates main window
//
//   COMMENTS:
//
//        In this function, we save the instance handle in a global variable and
//        create and display the main program window.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // Store instance handle in our global variable
   menuMain = LoadMenu(hInstance, MAKEINTRESOURCE(IDR_MENU2));
   menuVN = LoadMenu(hInstance, MAKEINTRESOURCE(IDR_MENU1));
   HWND hWnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, menuMain, hInstance, nullptr);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  FUNCTION: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  PURPOSE: Processes messages for the main window.
//
//  WM_COMMAND  - process the application menu
//  WM_PAINT    - Paint the main window
//  WM_DESTROY  - post a quit message and return
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    static int cnt = 0;
    static HMENU menuPopup;
    static POINT point[1000];
    static HDC hdcDraw;
    static int width;
    static int height;
    static HPEN hpen = CreatePen(PS_SOLID, 1, 0);
    static HBRUSH hbrush = CreateSolidBrush(RGB(255,255,255));
    static int Hinh, xLeft, yTop, xRight, yBottom;
    switch (message)
    {
    /*case WM_SIZE:
    {
        width = LOWORD(lParam);
        height = HIWORD(lParam);
    }
    break;*/
    case WM_LBUTTONDOWN: 
    {
        /*point[cnt].x = LOWORD(lParam);
        point[cnt].y = HIWORD(lParam);
        hdcDraw = GetDC(hWnd);
        SetPixel(hdcDraw, point[cnt].x, point[cnt].y, 0);
        ReleaseDC(hWnd, hdcDraw);
        cnt = cnt + 1;*/
        xLeft = LOWORD(lParam);
        yTop = HIWORD(lParam);
    }
    break;
    case WM_LBUTTONUP:
    {
        xRight = LOWORD(lParam);
        yBottom = HIWORD(lParam);
        hdcDraw = GetDC(hWnd);
        POINT pt[4];
        SelectObject(hdcDraw, hbrush);
        SelectObject(hdcDraw, hpen);
        switch (Hinh)
        {
        case ID_SHAPE_RECTANGLE:
            Rectangle(hdcDraw, xLeft, yTop, xRight, yBottom);
            break;
        case ID_SHAPE_ELIPSE:
            Ellipse(hdcDraw, xLeft, yTop, xRight, yBottom);
            break;
        case ID_SHAPE_TRIANGLE:
            pt[0].x = xLeft;
            pt[0].y = yBottom;
            pt[1].x = xLeft + (xRight - xLeft) / 2;
            pt[1].y = yTop;
            pt[2].x = xRight;
            pt[2].y = yBottom;
            Polygon(hdcDraw, pt, 3);
        case ID_SHAPE_CIRCLE:
            pt[0].x = xLeft + (xRight - xLeft) / 2;
            pt[0].y = yTop;
            pt[1].x = xLeft;
            pt[1].y = yTop + (yBottom - yTop) / 2;
            pt[2].x = xLeft + (xRight - xLeft) / 2;
            pt[2].y = yBottom;
            pt[3].x = xRight;
            pt[3].y = yTop + (yBottom - yTop) / 2;
            Polygon(hdcDraw, pt, 4);
        default:
            break;
        }
    }
    break;
    //case WM_RBUTTONDOWN:
    //{
    //    hdcDraw = GetDC(hWnd);
    //    /*menuPopup = GetSubMenu(menuMain, 1);
    //    POINT point;
    //    point.x = LOWORD(lParam);
    //    point.y = HIWORD(lParam);
    //    ClientToScreen(hWnd, &point);
    //    TrackPopupMenu(menuPopup, TPM_RIGHTBUTTON, point.x, point.y, 0, hWnd, NULL);*/
    //    for (int i = 0; i < cnt; i++) {
    //        for (int j = i + 1; j < cnt; j++) {
    //            MoveToEx(hdcDraw, point[i].x, point[i].y, NULL);
    //            LineTo(hdcDraw, point[j].x, point[j].y);
    //        }
    //    }
    //    ReleaseDC(hWnd, hdcDraw);
    //}
    break;
    /*case WM_LBUTTONDBLCLK:
    {
        InvalidateRect(hWnd, NULL, TRUE);
        cnt = 0;
    }*/
    case WM_COMMAND: 
    {
        int wmID = LOWORD(wParam);
        switch (wmID)
        {
        case ID_LANGUAGE_ENGLISH:
            SetMenu(hWnd, menuMain);
            break;
        case ID_LANGUAGE_VIETNAMESE:
            SetMenu(hWnd, menuVN);
            break;
        case ID_FILE_EXIT:
            if (MessageBox(NULL, TEXT("Do you wanna exit!"), TEXT("Exit"), MB_YESNO | MB_ICONQUESTION) == IDYES) {
                PostQuitMessage(0);
            }
            break;
        case ID_SHAPE_RECTANGLE:
            Hinh = ID_SHAPE_RECTANGLE;
            break;
        case ID_SHAPE_ELIPSE:
            Hinh = ID_SHAPE_ELIPSE;
            break;
        case ID_SHAPE_TRIANGLE:
            Hinh = ID_SHAPE_TRIANGLE;
            break;
        case ID_SHAPE_CIRCLE:
            Hinh = ID_SHAPE_CIRCLE;
            break;
        case ID_FILLCOLOR_GREEN:
            hbrush = CreateSolidBrush(RGB(0, 255, 0));
            break;
        case ID_FILLCOLOR_YELLOW:
            hbrush = CreateSolidBrush(RGB(255, 255, 0));
            break;
        case ID_OUTLINECOLOR_BLUE:
            hpen = CreatePen(PS_SOLID, 1, RGB(0, 0, 255));
            break;
        case ID_OUTLINECOLOR_RED:
            hpen = CreatePen(PS_SOLID, 1, RGB(255, 0, 0));
            break;
        default:
            break;
        }
    }
        break;
    /*case WM_PAINT:
    {
        POINT pt[] = { {100,100}, {200,100}, {200,200},{100,200}, {100,100} };
        PAINTSTRUCT ps;
        HPEN rdPen, ywPen, BlPen;
        HBRUSH greenBrush, blueBrush, redBrush;
        greenBrush = CreateSolidBrush(RGB(0, 255, 0));
        blueBrush = CreateHatchBrush(HS_DIAGCROSS, RGB(0, 255, 255));
        redBrush = CreateHatchBrush(HS_CROSS, RGB(255, 0, 0));
        HDC hdc = BeginPaint(hWnd, &ps);
        rdPen = CreatePen(PS_DASH, 1, RGB(255, 0, 0));
        ywPen = CreatePen(PS_SOLID, 1, RGB(255, 255, 0));
        BlPen = CreatePen(PS_DOT, 1, RGB(0, 0, 255));
        //MoveToEx(hdc, pt[0].x, pt[0].y, NULL);
        for (auto i : pt)
            LineTo(hdc, i.x, i.y);
        //Polygon(hdc, pt, 4);
        //Polyline(hdc, pt, 4);
        SelectObject(hdc, ywPen);
        SelectObject(hdc, redBrush);
        Rectangle(hdc, width / 8, height / 8, (width * 7) / 8, (height * 7) / 8);
        MoveToEx(hdc, 0, 0, NULL);
        SelectObject(hdc, rdPen);
        LineTo(hdc, width, height);
        MoveToEx(hdc, width, 0, NULL);
        LineTo(hdc, 0, height);
        SelectObject(hdc, BlPen);
        SelectObject(hdc, blueBrush);
        Ellipse(hdc, width / 8, height / 8, (width * 7) / 8, (height * 7) / 8);
        SelectObject(hdc, greenBrush);
        RoundRect(hdc, width / 4, height / 4, (width * 3) / 4, (height * 3) / 4, 200, 200);
        EndPaint(hWnd, &ps);
    }
    break;*/
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    
    return 0;
}

// Message handler for about box.
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
