// WNgoVanKhai_191200552_CNTT2_K60.cpp : Defines the entry point for the application.
//

#include "framework.h"
#include "WNgoVanKhai_191200552_CNTT2_K60.h"

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
    LoadStringW(hInstance, IDC_WNGOVANKHAI191200552CNTT2K60, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // Perform application initialization:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_WNGOVANKHAI191200552CNTT2K60));

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

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_WNGOVANKHAI191200552CNTT2K60));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_WNGOVANKHAI191200552CNTT2K60);
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

   HWND hWnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);

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
    static int m = 60, s = 0, width, height;
    HDC hdcText;
    static TCHAR timeLeft[50];
    static HDC hdcDraw;
    static HPEN hpen = CreatePen(PS_SOLID, 3, RGB(255,0,0));
    static HBRUSH hbrush = CreateSolidBrush(RGB(255, 255, 255));
    static int Hinh, xLeft, yTop, xRight, yBottom;
    switch (message)
    {
    case WM_CREATE:
    {
        SetTimer(hWnd, 1, 1000, NULL);
        break;
    }
    case WM_SIZE:
        width = LOWORD(lParam);
        height = HIWORD(lParam);
        break;

    case WM_TIMER:
        if (s > 0 and s <= 59) {
            s--;
        }
        else if (s == 0 and m > 0) {
            m--;
            s = 59;
        }
        if (s == 0 and m == 0) {
            KillTimer(hWnd, 1);
        }
        wsprintfW(timeLeft, L"Time Left: %d:%d", m, s);
        hdcText = GetDC(hWnd);
        SetTextColor(hdcText, RGB(255, 0, 0));
        TextOut(hdcText, width - 150, height - 50, timeLeft, 20);        
        ReleaseDC(hWnd, hdcText);
        break;
    case WM_LBUTTONDOWN:
    {
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
        case ID_HINH_ELLIPSE:
            Ellipse(hdcDraw, xLeft, yTop, xRight, yBottom);
            break;
        case ID_HINH_THOI:
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
    case WM_COMMAND:
        {
            int wmId = LOWORD(wParam);
            // Parse the menu selections:
            switch (wmId)
            {
            case ID_HINH_ELLIPSE:
                Hinh = ID_HINH_ELLIPSE;
                break;
            case ID_HINH_THOI:
                Hinh = ID_HINH_THOI;
                break;
            case ID_MAU_XANHLA:
                hbrush = CreateSolidBrush(RGB(0, 255, 0));
                break;
            case ID_MAU_VANG:
                hbrush = CreateSolidBrush(RGB(255, 255, 0));
                break;
            case ID_EXIT:                
                if (MessageBox(NULL, TEXT("Bạn có muốn thoát không?"), TEXT("Thoát"), MB_ICONQUESTION | MB_YESNO) == IDYES) {
                    DestroyWindow(hWnd);
                }
            break;
            case IDM_ABOUT:
                DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
                break;
            case IDM_EXIT:
                DestroyWindow(hWnd);
                break;
            default:
                return DefWindowProc(hWnd, message, wParam, lParam);
            }
        }
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HDC hdc = BeginPaint(hWnd, &ps);
            // TODO: Add any drawing code that uses hdc here...
            EndPaint(hWnd, &ps);
        }
        break;
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
